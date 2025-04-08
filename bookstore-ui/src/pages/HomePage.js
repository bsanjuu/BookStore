import React, { useEffect, useState } from 'react';
import axios from 'axios';

const HomePage = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/books')
            .then(res => setBooks(res.data))
            .catch(err => console.error(err));
    }, []);

    const purchaseBook = (id) => {
        axios.post(`http://localhost:8080/books/${id}/purchase`)
            .then(() => alert('Book purchased!'))
            .catch(err => console.error(err));
    };

    return (
        <div style={{ padding: '1rem' }}>
            <h2>Available Books</h2>
            <div style={{
                display: 'grid',
                gridTemplateColumns: 'repeat(auto-fill, minmax(250px, 1fr))',
                gap: '1rem'
            }}>
                {books.map(book => (
                    <div key={book.id} style={{
                        border: '1px solid #ccc',
                        borderRadius: '8px',
                        padding: '1rem',
                        boxShadow: '2px 2px 8px rgba(0,0,0,0.1)'
                    }}>
                        <h3>{book.title}</h3>
                        <p><strong>Author:</strong> {book.author}</p>
                        <p><strong>Price:</strong> ₹{book.price}</p>
                        <button onClick={() => purchaseBook(book.id)}>Buy</button>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default HomePage;
