package com.anztim.library.manager.service;

import com.anztim.library.manager.dao.BookDao;
import com.anztim.library.manager.dao.BookInfoDao;
import com.anztim.library.manager.domain.Book;
import com.anztim.library.manager.domain.BookInfo;
import com.anztim.library.manager.utils.HttpUtil;
import com.anztim.library.manager.utils.JSONUtil;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * @author anztim
 */
public class BookService {
    BookDao bookDao = new BookDao();
    BookInfoDao bookInfoDao = new BookInfoDao();
    ConfigService configService = new ConfigService();

    public BookInfo getBookInfoByBookId(String bookId) {
        BookInfo info = null;
        try {
            Book book = bookDao.getById(bookId);
            if (book == null) return null;
            info = getBookInfo(book.getBookInfoId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

    public List<Book> getBookByBookInfoId(int infoId) {
        List<Book> list = null;
        try {
            list = bookDao.basicQueryList("SELECT " +
                            "book_id, book_info_id, location " +
                            "FROM t_book WHERE book_info_id=?",
                    infoId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Book> getBookByBookInfoId(String isbn) {
        int infoId = isBookInfoExists(isbn);
        if (infoId == -1) return null;
        return getBookByBookInfoId(infoId);
    }

    public BookInfo getBookInfo(int bookInfoId) {
        BookInfo info = null;
        try {
            info = bookInfoDao.getById(bookInfoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

    public BookInfo getBookInfo(String isbn) {
        int infoId = isBookInfoExists(isbn);
        if (infoId == -1) return null;
        return getBookInfo(infoId);
    }

    public BookInfo createBookInfo(String isbn) {
        String urlStr = configService.get("book_info_api_url");
        if (urlStr == null) return null;
        JSONObject respond;
        BookInfo info = null;
        try {
            InputStream jsonInput = HttpUtil.getInputStream(urlStr.replaceAll("\\{isbn\\}", isbn));
            if (jsonInput != null) {
                // 从字节流读取数据并创建 JSON 对象
                Reader respondReader = new InputStreamReader(jsonInput, StandardCharsets.UTF_8);
                StringBuilder respondContent = new StringBuilder();
                char[] buffer = new char[8192];
                int buffered;
                while ((buffered = respondReader.read(buffer, 0, 8192)) >= 0) {
                    respondContent.append(buffer, 0, buffered);
                }
                respond = new JSONObject(respondContent.toString());
                JSONObject data = respond.getJSONObject("data");

                // 创建 BookInfo 对象
                BookInfo temp = new BookInfo();
                temp.setIsbn(data.getString("isbn"));
                temp.setCopies(0);
                temp.setTitle(data.getString("title"));
                temp.setSubtitle(data.getString("subtitle"));
                temp.setOriginalTitle(data.getString("original_title"));
                temp.setAuthor(data.getJSONArray("author").toString());
                temp.setTranslator(data.getJSONArray("translator").toString());
                temp.setPublish(data.getString("publish"));
                temp.setPublishDate(data.getString("publishDate"));
                temp.setPages(data.getInt("pages"));
                temp.setPrice(JSONUtil.valueOfMoney(data.getString("price")));
                temp.setBinding(data.getString("binging"));// 接口中的拼写错误
                temp.setSeries(data.getString("series"));
                temp.setDoubanId(data.getString("id"));
                temp.setBookIntro(data.getString("book_intro"));
                temp.setAuthorIntro(data.getString("author_intro"));
                // 通过 url 获取 cover
                InputStream coverInput = HttpUtil.getInputStream(data.getString("cover_url"));
                ByteArrayOutputStream toBytes = new ByteArrayOutputStream();
                byte[] bytes = new byte[8192];
                int len;
                while ((len = coverInput.read(bytes, 0, 8192)) >= 0) {
                    toBytes.write(bytes, 0, len);
                }
                temp.setCover(toBytes.toByteArray());
                info = temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public int insertBookInfo(String isbn) {
        BookInfo info = createBookInfo(isbn);
        int updated = 0;
        if (info != null) {
            updated = insertBookInfo(info);
        }
        return updated;
    }

    public int insertBookInfo(BookInfo info) {
        int updated = 0;
        if (info != null) {
            try {
                updated = bookInfoDao.insert(info);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updated;
    }

    public int refreshBookInfo(String isbn) {
        int updated = 0;
        int infoId = isBookInfoExists(isbn);
        if (infoId != -1) {
            BookInfo bookInfo = createBookInfo(isbn);
            if (bookInfo != null){
                bookInfo.setInfoId(infoId);
                updated = updateBookInfo(bookInfo);
            }
        } else {
            updated = insertBookInfo(isbn);
        }
        return updated;
    }

    public int refreshBookInfo(BookInfo info) {
        int updated;
        updated = refreshBookInfo(info.getIsbn());
        return updated;
    }

    public int updateBookInfo(BookInfo info) {
        int updated = 0;
        try {
            updated = bookInfoDao.update(info);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int isBookInfoExists(String isbn) {
        Integer book_id = null;
        try {
            Long temp = (Long) bookInfoDao.basicQueryScalar("SELECT info_id FROM t_book_info WHERE isbn=?", isbn);
            if (temp != null) {
                book_id = temp.intValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (book_id == null) return -1;
        return book_id;
    }

    public Book getBook(String bookId) {
        Book book = null;
        try {
            book = bookDao.getById(bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public int updateBook(Book book) {
        int updated = 0;
        try {
            updated = bookDao.update(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int deleteBook(Book book) {
        int updated = 0;
        try {
            updated = bookDao.basicUpdate("UPDATE t_book SET location='DELETED' WHERE book_id=?", book.getBookId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int addBook(String isbn, String location) {
        int updated = 0;
        int infoId = isBookInfoExists(isbn);
        if (infoId == -1) {
            BookInfo info = new BookInfo();
            info.setIsbn(isbn);
            insertBookInfo(info);
            refreshBookInfo(info);
            infoId = isBookInfoExists(isbn);
        }
        Book book = new Book();
        book.setBookId(UUID.randomUUID().toString());
        book.setBookInfoId(infoId);
        book.setLocation(location);
        try {
            updated = bookDao.insert(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public List<BookInfo> searchBookInfo(String target) {
        List<BookInfo> result = null;
        target = '%'+target+'%';
        try {
            result = bookInfoDao.basicQueryList("SELECT info_id,isbn,copies,title,subtitle,original_title,author,translator,publish,publishDate,pages,price,binding,series FROM t_book_info WHERE title LIKE ? OR subtitle LIKE ? OR original_title LIKE ?",
                    target, target, target
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
