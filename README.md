This application simulates a school of courses where it shows all the people registered and is also divided by categories, students, teachers, subjects and directors.
The student category shows the data of all students with their respective teachers and subjects.
The teacher category shows the data of all teachers with their respective students and subjects.
In the subject category, the data of all the subjects with their respective students and teachers are shown.
And in the director category the data of all directors is displayed.
Also, in the students section you can update, delete and register a student, but only people with ADMIN rank can do so.
There are two types of authorization, a user and an administrator.
The User can see all the pages except the update, deletion and registration of a student, where the user tries to access, an error page will be displayed and they will return to the previous page.
The administrator can access all the pages found in the application.

TOOLS USED IN THE APPLICATION: Spring MVC, Spring Security, Spring Data JPA, Hibernate, TDD, Validations, Paginations, Thymeleaf, HTML, CSS, MySQL and Maven.


RELATIONS BETWEEN CLASSES: A student, teacher, subject and director can access their classes that are related in a LAZY way, I chose this route because I think it is the most correct although in my application it does not handle much data.
