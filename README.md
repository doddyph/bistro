# bistro
Spring REST JPQL Demo

For testing: <br />
$ curl localhost:8080/recipes/search/findbyname?name=apple%20crumble <br />
$ curl localhost:8080/recipes/search/findByName?name=Apple%20Crumble <br />
$ curl localhost:8080/recipes/search/findbyid?id=13 <br />
$ curl localhost:8080/recipes/search/findById?id=13 <br />
$ curl -sS 'localhost:8080/recipes/search/findByNameAndDescription?name=Recipe%20A&description=Recipe%20A%20description' <br />
$ curl -sS 'localhost:8080/recipes/search/findByNamaDanDeskripsi?name=Recipe%20A&description=Recipe%20A%20description' <br />

Links: <br />
http://lornajane.net/posts/2011/inner-vs-outer-joins-on-a-many-to-many-relationship <br />
http://howtodoinjava.com/jpa/jpa-native-select-sql-query-example/ <br />
https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/ <br />
https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-three-custom-queries-with-query-methods/ <br />
https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-with-the-query-annotation/ <br />
