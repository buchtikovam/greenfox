# AvusSIC Foundation Normal Exam

## Getting Started

- **Fork** this repository under your own account
- Clone your forked repository to your computer
- Create a `.gitignore` file so generated files won't be committed
- Commit your progress frequently and with descriptive commit messages
- All your answers and solutions should go in this repository
- Take care of style guide
- Take care of the naming of classes, fields, variables, files, etc.

## Keep in mind

- You can use any resource online, but **please work individually**
- AI help is not allowed (eg. chatGPT, copilot, ...)
- **Don't just copy-paste** your answers and solutions,
  you need to understand every line of your code
- **Don't push your work** to GitHub until your mentor announces
  that the time is up
- At the end of the exam push your solution to **GitHub** and upload it to GradeScope

### Java

- Use [JDK 11](## "Using API from versions newer than Java 11 may result in syntax errors on Gradescope")
- All of your classes must be in the `com.gfa.exam` package! no sub-packages ☠️
- Use the correct class names, i.e. `TextFromMatrix`, `A66Entering`, `Bookshelf`, `Paperback` etc.
- Make sure to declare all required classes and methods as `public`
- Using of `Stream` is **not allowed** in this exam
- At the end of the exam upload your solution to **Gradescope** too

## GradeScope notes

- One hour before the end of the exam you can push your solution to **Gradescope**
- You may upload to GradeScope multiple times in the allocated time
- Upload your solution to GradeScope as a **zip** file of the `src` folder

## Exercises

### Text from matrix

Write a class `TextFromMatrix` with a method called `extractFrom` which takes a `2D array / matrix` containing characters
and returns a text.
The method creates the text from the letters found in the matrix.

If the input is null, method should throw IllegalArgumentException.

Which letters to select:

- from every even row, select the letter found in the even columns
- from every odd row, select the letter found in the odd columns

The letters should be concatenated in this order: from left-top to right-bottom.

Write 2 different unit test cases for the method.

#### Example 1

Input

```text
[
  ['n', 'x'],
  ['m', 'o']
]
```

Output

```text
"no"
```

#### Example 2

Input

```text
[
  ['h', 'p', 'e'],
  ['k', 'l', 'a'],
  ['l', 'm', 'o']
]
```

Output

```text
"hello"
```

### A66 entering

The office building "A66" (the home of the Green Fox HQ) can be entered with a
key card.
Write a class `A66Entering` with a method called `getMainDoorUsage` that takes a filename as (string) parameter:

- Which can read and parse a file
  containing information about the chip usage at A66.
- The method returns a map containing how many times each chip was used at the door called
  _`(A66 - 04 FÕBEJÁRAT (F-1) Door #1)`_.
- When the specified file does not exist then print the message
  `File not found` to the console
- In case of invalid input, e.g. parameter is null, throw `IllegalArgumentException`

During development, you will need only two fields from the input file:

- Description #1 - the used door
- Card number

#### Example

[Example file can be found here.](src/com/gfa/exam/logs.csv)

_Note_: the csv input file does _not_ contain headers (on line 1)
(CSV means Comma Separated Values)

Each line represents an entry and see the first line below for explanation of what information you can find in the file:
(_this first line is not in the example file above!_)

```csv
Id,Date and Time,Event message,Event number,Object #1,Description #1,Object #2,Description #2,Object #3,Description #3,Object #4,Description #4,Card number
1,2019.01.02. 9:21:49,Access granted,203,12,A66 - 04 FÕBEJÁRAT (F-1) Door #1,5,Czender András,0,,0,,00215:09895
...
```

Output

```
{
  ...,
  '00088:56736': 3,
  '00247:27091': 2,
  '00038:28945': 2,
  '00155:46240': 1,
  '00089:01168': 2,
  '00042:36689': 1,
  '00153:30309': 1
}
```

### Bookshelf

Write a program which can store books on a bookshelf.

There are two types of books.

#### `Book`

- Every book has a `title`, an `author`, a `release year`, `numberOfPages`, and `weight` in grams.

- It has a `getBookInfo()` method that returns a string
  in the following format: `author: title (year)`
  - For example:`J. K. Rowling: Harry Potter and the Philosopher's Stone (1997)`

#### `Hardcover` (book)

- The weight should be calculated from the number of pages (every page weighs
  10 grams) plus the weight of the cover which is 100 grams.

#### `Paperback` (book)

- The weight should be calculated from the number of pages (every page weighs
  10 grams) plus the weight of the cover which is 20 grams.

#### `Bookshelf`

- It receives the `capacity` (i.e. the max. number of books that it can store) as
  a constructor argument. It stores `books` (if you're brave, use HashSet<Book>, but ArrayList<Book> will do too)

- It has an `addBook(Book)` method where you can add books to the bookshelf, which
  should throw `RuntimeException` if the bookshelf is already full with a message "Bookshelf is already full!".

- It has a `getBooks(year)` method which takes a year as a parameter, and
  returns Map<String, String> of books that were released in that year in the following format:

  ```text
  {
    <book title>: <author>,
    <book title>: <author>,
    <book title>: <author>,
    <book title>: <author>
  }
  ```

- It has a `getLightestAuthor()` method that returns the author
  of the lightest book.

- It has a `getMaxAuthor()` method that returns the author who
  wrote the most pages.

- It has a `printBooks()` method that prints all the information about the books. Take advantage of the Book's `getBookInfo()` method

## Command line exercise

- Take a look at this directory structure:

```text
homework
 |--math
 |   |--.git
 |   |--calculus
 |   |   |--jacobian_matrix.md
 |   |   └--exercises
 |   |       └--week01_hw.txt
 |   └--geometry
 |       |--week01_hw.txt
 |       └--pithagorean_theorem.md
 └--history
     |--.git
     |--taylor_polynomial.md
     |--history_of_rome.md
     └--history_of_greece.md
```

- Your task is to write commands in the correct order from the directory given below.
- Do it with the smallest number of commands possible without chaining them together.
- Assume that the following files are currently in the staging area:
  - `math/calculus/jacobian_matrix.md`
  - `math/geometry/pithagorean_theorem.md`
- Your current directory is `homework/`

  1. Create an `exercises` directory in `math/geometry/`
  1. Move `geometry/week01_hw.txt` to `math/geometry/exercises/`
  1. Move `history/taylor_polynomial.md` to `math/calculus/`
  1. Remove `math/geometry/pithagorean_theorem.md` from the staging area
  1. Rename `math/geometry/pithagorean_theorem.md` to `math/geometry/pythagorean_theorem.md`
  1. Commit all the changes

- Solution:

```text
1. mkdir -p math/geometr/exercises
2. mv math/geometry/week01_hw.txt math/geometry/exercises/
3. mv history/taylor_polynomial.md math/calculus/
4. git reset math/geometry/pithagorean_theorem.md
5. mv math/geometry/pithagorean_theorem.md math/geometry/pythagorean_theorem.md
6. git add . ; git commit -m "Add new directory, move files, rename file"

```
