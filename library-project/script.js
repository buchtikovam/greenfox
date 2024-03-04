class Book {
    constructor (
        title,
        author,
        img,
        pages,
        isRead,
    ) {
        this._title = title;
        this._author = author;
        this._img = img;
        this._pages = pages;
        this._isRead = isRead;
    }

    toggleIsRead = function () {
        this._isRead = this._isRead !== true;
    }

    getTitle() {
        return this._title;
    }

    getAuthor() {
        return this._author;
    }

    getImg() {
        return this._img;
    }

    getPages() {
        return this._pages;
    }

    getIsRead() {
        return this._isRead;
    }
}

class Library {
    _books = []

    constructor() {
        // Default books
        let books = [
            new Book(
                "Fourth Wing",
                "Rebecca Yarros",
                "https://m.media-amazon.com/images/I/A1yI0aFggmL._AC_UF1000,1000_QL80_.jpg",
                498,
                true
            ),
            new Book(
                "The Green Mile",
                "Stephen King",
                "https://www.slovart.cz/buxus/images/image_28125_19_v1.jpeg",
                512,
                true
            ),
            new Book(
                "A Little Life",
                "Hanya Yanagihara",
                "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1446469353i/22822858.jpg",
                720,
                false
            ),
        ]

        // saved books
        const localStorageBooks = localStorage.getItem("books");
        if (localStorageBooks !== null && localStorageBooks !== '') {
            books = JSON.parse(localStorageBooks)
        }

        this._books = Array.from(new Set(books.map(objectToString => JSON.stringify(objectToString))))
            .map(stringToObject => JSON.parse(stringToObject))
            .map((book) => Object.assign(new Book, book));
    }

    getBooks() {
        return this._books;
    }

    getBook(index) {
        return this._books[index];
    }

    addBook(book) {
        this._books.push(book);
        this.saveBooks();
    }

    deleteBook(index) {
        this._books.splice(index, 1);
        this.saveBooks();
    }

    saveBooks() {
        localStorage.setItem("books", JSON.stringify(this._books))
    }
}

const library = new Library();
renderBooks();

const dialog = document.querySelector("dialog");

const showButton = document.getElementById("show-button");
showButton.addEventListener("click", () => dialog.showModal());

const closeButton = document.getElementById("close-button");
closeButton.addEventListener("click", () => dialog.close());

const form = document.getElementById("new-book-form");
form.addEventListener("submit", (event) => {
    event.preventDefault();

    form.reset();
    dialog.close();

    addBook(
        new Book(
            document.getElementById("title").value,
            document.getElementById("author").value,
            document.getElementById("img").value,
            document.getElementById("pages").value,
            document.querySelector('input[name="is-read"]:checked').value
        ),
    );
})

function renderBooks() {
    let container = document.getElementById("book-container");
    let existingGrid = document.getElementById("book-grid");

    if (typeof(existingGrid) !== 'undefined' && existingGrid != null) {
        container.removeChild(existingGrid);
    }

    let grid = document.createElement("div");
    grid.setAttribute("id", "book-grid");

    library.getBooks().forEach((book, index) => {
        let title = document.createElement("h3");
        title.textContent = book.getTitle();

        let author = document.createElement("p");
        author.textContent = `Author: ${book.getAuthor()}`;

        let img = document.createElement("img");
        img.setAttribute("src", book.getImg());
        img.setAttribute("alt", "book cover");
        img.setAttribute("width", "100px");

        let pages = document.createElement("p");
        pages.textContent = `${book.getPages()} pages`;

        let isRead = document.createElement("p");
        isRead.textContent = "State: " + (book.getIsRead() === true ? "finished" : "not read yet");

        let toggleIsReadBtn = document.createElement("button");
        toggleIsReadBtn.textContent = (book.getIsRead() === true ? "Unfinish" : "Finish") + "book";
        toggleIsReadBtn.addEventListener("click", () => toggleIsRead(index))

        let deleteBookBtn = document.createElement("button");
        deleteBookBtn.textContent = "Delete book";
        deleteBookBtn.addEventListener("click", () => deleteBook(index))

        let child = document.createElement("div");
        child.append(title, author, img, pages, isRead, toggleIsReadBtn, deleteBookBtn);
        grid.appendChild(child);
    })

    container.appendChild(grid);
}

function addBook(book) {
    library.addBook(book);
    renderBooks();
}

function toggleIsRead(index) {
    library.getBook(index).toggleIsRead();
    renderBooks();
}

function deleteBook(index) {
    library.deleteBook(index);
    renderBooks();
}