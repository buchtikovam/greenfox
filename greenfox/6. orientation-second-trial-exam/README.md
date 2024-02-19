# avus-practice-orientation-exam

## Getting Started

- **Fork** this repository to your own account
- Clone the forked repository to your computer
- Create a new folder `exam` and a new Java Spring Book / Gradle project 
inside it. Your repository folder structure should resemble the following:

```
!git/
assets/
├─ backend-index.png
├─ backend-rating.png
templates/
├─ mentors/
│  ├─ index.html
│  ├─ detail.html
├─ layouts/
│  ├─ layout.html
exam/
├─ .gradle/
├─ .idea/
├─ build/
├─ gradle/
├─ src/
├─ .gitignore
├─ build.gradle
├─ gradlew
├─ gradlew.bat
├─ settings.gradle
README.md
```
- Commit your progress frequently and with descriptive commit messages

## Keep in mind

- You can use any resource online, but **please work individually**

- **Don't just copy-paste** your answers and solutions, use your own words
  instead

- **Don't push your work** to GitHub until your mentor announces that the time
  is up

- Before diving to coding **think about the structure**



# Mentor Scheduler

We are going to create the **base** of our very own tool to store which mentors
are placed in which class to avoid confusion in the future.

**Please read the whole description in order to understand how the application
is supposed to work.**

## Database

It is up to you to define what the database model will look
like, it just needs to help fulfill outlined functionality.

For purposes of this project, each mentor can only be located
in one class at a time.

Only requirements are:

* all the mentor and class data needs to be stored in database
* mentors and classes will be stored in separated tables
* there will be some relationship between these tables

## Tasks

## GET `/`

![index](backend-rating.png)

- The main page should be rendered

- It should list the mentors that are already in the database as links

- The mentor links should point to GET `/mentor/{id}`

- To be able to extend the list of mentors, we should include a form
  on the main page as well

- The form should contain:

  - One input field for name with label

  - Drop-down button list, with each option corresponding to one of the existing
    classes that will assign mentor to this class

- The form should be submitted to POST `/mentor`


## POST `/mentor`

- Save the mentor in the database

- If the mentor already exists in the database, then it should
  render a simple error page with a descriptive error message

- Redirect to the page with the evaluation form of the given mentor
  GET `/mentor/{id}`

## GET `/mentor/{id}`

![rating](backend-index.png)

- The page should render the details of the mentor that is specified in the path

- It should include:

  - The name of the mentor
  - Which class he/she belongs to

- In case the mentor with the given ID does not exist, the application should
  render a simple error page

## GET `api/mentors?className=really`

- This endpoint should respond in JSON format with mentors from the
  `Really` class

  ```json
  [
    {
      "name": "Gabor"
    },
    {
      "name": "Szirmi"
    },
    {
      "name": "Bence"
    }
  ]
  ```

- Class name in the URL is required, it should return `400` status code
  in case the class name is not valid (it doesn't exist in database)
    - For example, if the `Roboto` class doesn't exist then the
      `api/mentors?className=roboto` should return `400` status code

## PUT `/api/mentors/{mentorId}`

- This endpoint should update the mentor specified in `mentorId`

- The name and class should be in the request's body in JSON format, this is how
  we will be able to modify its values

  ```json
  {
    "name": "Gabor",
    "className": "Tiptop"
  }
  ```

- If className property in received JSON isn't valid, application should respond with
  return with `400` status code

- In case there is no mentor with given `mentorId`, the application must respond
  with `404` status code


## SQL Question

Given the following table named `employees`

| id | name            | role         |
|:---|:----------------|:-------------|
| 1  | Bořivoj Souček  | mentor       |
| 2  | Kocsis Ivett    | psychologist |
| 3  | Papp Patrícia   | mentor       |
| 4  | Dagmar Benešová | psychologist |

And given the following table named `devices`

| id | name                  | serial_number | type   | employee_id | price |
|:---|:----------------------|:--------------|:-------|:------------|-------|
| 1  | Bořivoj's iPhone      | 123-412-512   | mobile | 1           | 200   |
| 2  | Kocsis Ivett's device | 321-234-155   | laptop | 2           | 350   |
| 3  | Bořivoj's mobile      | 321-234-155   | mobile | 1           | 170   |
| 4  | Dagmar's mobile       | 810-344-999   | mobile | 4           | 120   |
| 5  | Kocsis's laptop       | 242-756-327   | laptop | 2           | 270   |
| 6  | Papp's mobile         | 554-756-327   | mobile | 3           | 245   |

Write an SQL query to do the following:

1. Write a query that will display serial number of every **mobile** (not laptops or anything else) device, along with name and role of their owner.

```mysql

```

2. Write a query that will delete all laptop devices that are less than 300 in price.

```mysql

```
   
3. Write a query that will display the cost of most expensive device each employee owns:

```mysql

```

4. Write an SQL query to find the total price of devices for each employee. Your result should include the employee's name and the total price.

```mysql

```



