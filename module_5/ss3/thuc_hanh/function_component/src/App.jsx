import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import AddComponent from "./components/AddComponent.jsx";

function App() {
  return < AddComponent firstNumber={1} secondNumber={2} />
}

export default App
