import { Routes, Route } from "react-router-dom"
import HomePage from "../pages/HomePage"
import MainLayout from "../layouts/MainLayout"

import LoginPage from "../pages/LoginPage"
import RegisterPage from "../pages/RegisterPage"
import ProtectedRoute from "./ProtectedRoute"
import AdminRoute from "./AdminRoute"

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/login" element={<LoginPage />} /> 
      <Route path="/register" element={<RegisterPage />} />

      <Route element={<ProtectedRoute />}>
        <Route element={<MainLayout />}>
          <Route path="/" element={<HomePage />} />
        </Route>
      </Route>

      <Route element={<AdminRoute />}>
        <Route path="/admin" element={<h1>Admin Page</h1>} />
      </Route>
    </Routes>
  )
}

export default AppRoutes