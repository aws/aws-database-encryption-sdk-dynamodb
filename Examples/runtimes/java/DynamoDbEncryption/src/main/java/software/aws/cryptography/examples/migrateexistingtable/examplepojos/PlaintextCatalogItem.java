package software.aws.cryptography.examples.migrateexistingtable.examplepojos;

import java.util.Set;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class PlaintextCatalogItem {
  private Integer id;
  private String title;
  private String ISBN;
  private Set<String> bookAuthors;

  @DynamoDbPartitionKey
  public Integer getId() { return id; }
  public void setId(Integer id) {this.id = id; }

  public String getTitle() {return title; }
  public void setTitle(String title) { this.title = title; }

  public String getISBN() { return ISBN; }
  public void setISBN(String ISBN) { this.ISBN = ISBN; }

  public Set<String> getBookAuthors() { return bookAuthors; }
  public void setBookAuthors(Set<String> bookAuthors) { this.bookAuthors = bookAuthors; }
}