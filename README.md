# coding-events-demo

If a "person" class was to be added to this program, consider following design:

--
Person Class (models)

id int;
first_name String;
last_name String;
email String;
password String;

@ManyToMany
private final List<Events> eventAttendee;

@OneToMany
private final List<Events> eventOrganizer;

constructor - full;
constructor - no args for JPA;

get /set - first_name;
get/set - last_name;
get / set - email;
set - password;

--
PersonController Class (controllers)

displayUsers();
displayCreateUserForm();
processCreateUserForm();

--
PersonRepository Interface (data)
