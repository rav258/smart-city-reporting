import { Routes, Route } from "react-router-dom"
import HomePage from "../pages/HomePage.tsx"
import MainLayout from "../layouts/MainLayout"

const AppRoutes = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route path="/" element={<HomePage />} />
      </Route>
    </Routes>
  )
}

export default AppRoutes