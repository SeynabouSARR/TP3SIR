package domain;

import dao.morphia.AddressDAO;
import dao.morphia.ArticleDAO;
import dao.morphia.PersonDAO;
import java.util.List;

public class Principal {

  static final String DATABASE_NAME = "_tp3_";

  /**
   * La fonction principal.
   * @param args : les arguments fournis
   */
  public static void main(String[] args) {

    Address addressBoisPerrin11 = new Address();
    addressBoisPerrin11.setStreet("11 Rue du bois perrin");
    addressBoisPerrin11.setCity("Rennes");
    addressBoisPerrin11.setPostCode("35700");
    addressBoisPerrin11.setCountry("France");

    Address addressBoisPerrin13 = new Address();
    addressBoisPerrin13.setStreet("13A Rue du bois perrin");
    addressBoisPerrin13.setCity("Rennes");
    addressBoisPerrin13.setPostCode("35700");
    addressBoisPerrin13.setCountry("France");

    Address addressCessonSevigne = new Address();
    addressCessonSevigne.setStreet("70 Rue de Rennes");
    addressCessonSevigne.setCity("Cesson Sevigné");
    addressCessonSevigne.setPostCode("35510");
    addressCessonSevigne.setCountry("France");

    //Key<Address> cle1 = ds.save(address_bois_perrin11);

    AddressDAO managerAddress = new AddressDAO(DATABASE_NAME);
    managerAddress.save(addressBoisPerrin11);
    managerAddress.save(addressBoisPerrin13);
    managerAddress.save(addressCessonSevigne);
    System.out.println("Enregistrement des adresses terminées");

    Person seynabou = new Person();
    seynabou.setName("Seynabou SARR");
    Person melaine = new Person();
    melaine.setName("Melaine BOUE");
    Person meco = new Person();
    meco.setName("Meco DEBOUE");

    melaine.addAddress(addressBoisPerrin11);
    seynabou.addAddress(addressBoisPerrin13);
    meco.addAddress(addressCessonSevigne);

    PersonDAO managerPerson = new PersonDAO(DATABASE_NAME);
    managerPerson.save(melaine);
    managerPerson.save(seynabou);
    managerPerson.save(meco);
    System.out.println("Enregistrement des personnes terminées");

    Article myHpComputer = new Article();
    myHpComputer.setStars(5);
    myHpComputer.setName("HP LAPTOP OIE");
    myHpComputer.addBuyer(seynabou);
    ArticleDAO managerArticle = new ArticleDAO(DATABASE_NAME);
    managerArticle.save(myHpComputer);

    Article telephoneIphone = new Article();
    telephoneIphone.setStars(5);
    telephoneIphone.setName("iPhone 7S");
    telephoneIphone.addBuyer(seynabou);
    telephoneIphone.addBuyer(melaine);
    telephoneIphone.addBuyer(meco);
    managerArticle.save(telephoneIphone);

    System.out.println("Enregistrement des articles");
    //Article article_a_effacer = managerArticle.find("iPhone 7S");
    //managerArticle.delete(article_a_effacer);
    List<Article> articles = managerArticle.getList();

    System.out.println("--------------------------------------------------------");
    int compteur = 1;
    for (Article article : articles) {
      System.out.println(compteur + " " + article);
      compteur++;
    }
    System.out.println("--------------------------------------------------------");
  }

}
