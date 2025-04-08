import React, { useEffect, useState } from 'react';
import axios from 'axios';

const HomePage = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/books')
            .then(res => setBooks(res.data))
            .catch(err => console.error(err));
    }, []);

    return (
        <div style={{ padding: '2rem' }}>
            <h1>📚 Available Books</h1>
            <ul>
                {books.map(book => (
                    <li key={book.id}>
                        <strong>{book.title}</strong> by {book.author} — ₹{book.price}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default HomePage;
