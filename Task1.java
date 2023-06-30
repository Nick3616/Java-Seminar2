// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} select * from students where 'name=Ivanov' and 'country=Russia' and...



public class Task1 {
    public static void main(String[] args) {
        String query = "select * from students where ";
        String filtersString = "\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":null";
        String[] filtersArray = filtersString.split(",");

            for (String filter : filtersArray) {
                String[] keyValue = filter.split(":");
                String key = keyValue[0].replace("\"", "").trim();
                String value = keyValue[1].replace("\"", "").trim();

                if (!value.equals("null")) {
                    query += key + "=" + value + " and ";
                }
            }

            if (query.endsWith(" and ")) {
                query = query.substring(0, query.length() - 5);
            }
            System.out.println(query);
    }
}