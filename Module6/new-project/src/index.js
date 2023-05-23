import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
const root = ReactDOM.createRoot(document.getElementById('root'));
const students=[
    {
        company: 'Alfreds Futterkiste',
        contact: 'Maria Anders',
        country: 'Germany'
    },
    {
        company: 'Centro comercial Moctezuma',
        contact: 'Francisco Chang',
        country: 'Mexico'
    },
    {
        company: 'Ernst Handel',
        contact: 'Roland Mendel',
        country: 'Austria'
    },
    {
        company: 'Island Trading',
        contact: 'Helen Bennett',
        country: 'UK'
    },
    {
        company: 'Laughing Bacchus Winecellars',
        contact: 'Yoshi Tannamuri',
        country: 'Canada'
    },
    {
        company: 'Magazzini Alimentari Riuniti',
        contact: 'Giovanni Rovelli',
        country: 'Italy'
    }
]
const tableRows = students.map((student,index) =>(
    <tr  key={index}>
        <td>{student.company}</td>
        <td>{student.contact}</td>
        <td>{student.country}</td>
    </tr>
));
root.render(
    <table>
        <tr>
            <th>Company</th>
            <th>Contact</th>
            <th>country</th>
        </tr>
        {tableRows}
    </table>
);
// root.render(
//   <table>
//     <tr>
//       <th>Company</th>
//       <th>Contact</th>
//       <th>country</th>
//     </tr>
// {students.map(student=>(
//   <tr>
//     <td>{student.company}</td>
//     <td>{student.contact}</td>
//     <td>{student.country}</td>
//   </tr>
// ))}
//   </table>
// );
// dùng for
// const tableRows = [];
// for (let i = 0; i < students.length; i++) {
//   const student = students[i];
//   tableRows.push(
//     <tr key={i}>
//       <td>{student.company}</td>
//       <td>{student.contact}</td>
//       <td>{student.country}</td>
//     </tr>
//   );
// }
// root.render(
//   <table>
//     <tr>
//       <th>Company</th>
//       <th>Contact</th>
//       <th>Country</th>
//     </tr>
//     {tableRows}
//   </table>
// );
