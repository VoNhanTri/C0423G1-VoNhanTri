import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {Route, Routes} from "react-router-dom";
import BookList from "./components/BookList.jsx";
import BookAdd from "./components/BookAdd.jsx";

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Routes>
          <Route path="/" element={<BookList/>}/>
          <Route path="/add" element={<BookAdd/>}/>
      </Routes>
    </>
  )
}

export default App
