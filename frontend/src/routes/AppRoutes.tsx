import { Routes, Route } from "react-router-dom"
import HomePage from "../pages/HomePage"
import MainLayout from "../layouts/MainLayout"

import LoginPage from "../pages/LoginPage"
import RegisterPage from "../pages/RegisterPage"

const AppRoutes = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route path="/" element={<HomePage />} />
      </Route>

      <Route path="/login" element={<LoginPage />} />
      <Route path="/register" element={<RegisterPage />} />
    </Routes>
  )
}

export default AppRoutes