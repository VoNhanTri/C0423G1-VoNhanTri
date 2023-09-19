import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Student from "./components/Student.jsx";

function App() {
  const student = [
    {
      id: '1',
      name: 'Nguyen Van A',
      age: '29',
      address: 'Quang Ngai'
    },
    {
      id: '2',
      name: 'Nguyen Van B',
      age: '29',
      address: 'Quang Ngai'
    },
    {
      id: '3',
      name: 'Nguyen Van C',
      age: '28',
      address: 'Quang Ngai'
    }
  ]
  return (

    < Student student={student}

    />
  )
}

export default App
