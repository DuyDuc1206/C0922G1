import TodoList from './component/TodoList';

function App() {
  const names = ['John', 'Jane', 'Bob', 'Alice'];
  const name = 'John';
  return (
      <div>
        <h2>Hello, {name}!</h2>
        <h1>List of Names:</h1>
        <ul>
          {names.map(name => (
              <li >{name}</li>
          ))}
        </ul>

      </div>
  );
}

export default App;

// import React from 'react';
// import ReactDOM from 'react-dom/client';
// import './index.css';
// import App from './App';
// import reportWebVitals from './reportWebVitals';
//
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//     <React.StrictMode>
//         <App />
//     </React.StrictMode>
// );
//
// // If you want to start measuring performance in your app, pass a function
// // to log results (for example: reportWebVitals(console.log))
// // or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();
