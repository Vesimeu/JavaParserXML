package com.example.xmlparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainParser {

    public static void main(String[] args) {
        String filePath = "src/main/resources/random_structure_46.xml";
        try {
            // Чтение содержимого файла в строку
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Парсинг XML вручную
            List<Book> books = parseBooks(content);

            // Вывод информации о книгах
            for (Book book : books) {
                System.out.println(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Функция для парсинга книг
    private static List<Book> parseBooks(String content) {
        List<Book> books = new ArrayList<>();
        String[] bookBlocks = content.split("<book"); // Разделение по тегам <book
        for (String block : bookBlocks) {
            if (block.contains("<title>")) {
                Book book = new Book();
                book.setId(extractAttribute(block, "id"));
                book.setTitle(extractTagValue(block, "title"));
                book.setAuthor(extractTagValue(block, "author"));
                book.setYear(extractTagValue(block, "year"));
                book.setGenre(extractTagValue(block, "genre"));
                book.setPrice(extractTagValue(block, "price"));
                book.setCurrency(extractAttribute(block, "currency", "price"));
                book.setIsbn(extractTagValue(block, "isbn"));
                book.setFormat(extractTagValue(block, "format"));
                book.setLanguage(extractTagValue(block, "language"));
                book.setTranslator(extractTagValue(block, "translator"));

                // Парсинг издательства, если присутствует
                if (block.contains("<publisher>")) {
                    Publisher publisher = new Publisher();
                    publisher.setName(extractTagValue(block, "name"));
                    Address address = new Address();
                    address.setCity(extractTagValue(block, "city"));
                    address.setCountry(extractTagValue(block, "country"));
                    publisher.setAddress(address);
                    book.setPublisher(publisher);
                }

                // Парсинг наград, если присутствуют
                if (block.contains("<awards>")) {
                    List<String> awards = new ArrayList<>();
                    String[] awardBlocks = block.split("<award>");
                    for (String awardBlock : awardBlocks) {
                        if (awardBlock.contains("</award>")) {
                            awards.add(awardBlock.substring(0, awardBlock.indexOf("</award>")).trim());
                        }
                    }
                    book.setAwards(awards);
                }

                // Парсинг рецензий, если присутствуют
                if (block.contains("<reviews>")) {
                    List<Review> reviews = new ArrayList<>();
                    String[] reviewBlocks = block.split("<review>");
                    for (String reviewBlock : reviewBlocks) {
                        if (reviewBlock.contains("</review>")) {
                            Review review = new Review();
                            review.setUser(extractTagValue(reviewBlock, "user"));
                            review.setRating(Integer.parseInt(extractTagValue(reviewBlock, "rating")));
                            review.setComment(extractTagValue(reviewBlock, "comment"));
                            reviews.add(review);
                        }
                    }
                    book.setReviews(reviews);
                }

                books.add(book);
            }
        }
        return books;
    }

    // Функция для извлечения значения из тега
    private static String extractTagValue(String block, String tagName) {
        String openTag = "<" + tagName + ">";
        String closeTag = "</" + tagName + ">";
        if (block.contains(openTag) && block.contains(closeTag)) {
            return block.substring(block.indexOf(openTag) + openTag.length(), block.indexOf(closeTag)).trim();
        }
        return null;
    }

    // Функция для извлечения атрибутов (например, id, currency)
    private static String extractAttribute(String block, String attributeName) {
        return extractAttribute(block, attributeName, null);
    }

    // Расширенная функция для извлечения атрибутов с возможностью указания родительского тега
    private static String extractAttribute(String block, String attributeName, String parentTag) {
        String tagStart = parentTag != null ? "<" + parentTag : "";
        String attributeString = attributeName + "=\"";
        if (block.contains(tagStart) && block.contains(attributeString)) {
            int startIndex = block.indexOf(attributeString) + attributeString.length();
            int endIndex = block.indexOf("\"", startIndex);
            return block.substring(startIndex, endIndex).trim();
        }
        return null;
    }
}
