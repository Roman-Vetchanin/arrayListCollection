Простой сервис на Java для учета сотрудников. </br>
Стек технологий: </br>
Java 17 </br>
Spring framework </br>
Для хранения всей информации о сотрудниках использовано HashMap.</br>
Запуск проекта осуществляется через IDE. После запуска необходиа перейти в по адресу http://localhost:8080/department. </br>
And-points:</br>
-/max-salary дает информацию по максимальной з/п в отделе.</br>
-/min-salary дает информацию по минимальной з/п в отделе.</br>
-/printDepartmentAll?departmentId={departmentId} дает информацию по сотрудника в департаменте.</br>
-/printDepartmentAll дает информацию по всем департаментам и их сотрудникам.</br>
Работа с сотрудниками http://localhost:8080/employee. </br>
-/add?firstName={firstName}&lstName={lastName}&department={department}&salary={salary} добавляет нового сотрудника.</br>
-/remove?firstName={firstName}&lstname={lastName} удаляеи сотрудника имени и фамилии.</br>
-/find?firstName={firstName}&lstname={lastName} найти сотрудника по имени и фамилии.</br>
-/print выводит всех сотрудников и в каком департаменте.
