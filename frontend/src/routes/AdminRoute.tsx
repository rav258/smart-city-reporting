import { Navigate, Outlet } from "react-router-dom"
import { auth } from "../utils/auth"

const AdminRoute = () => {
  if (!auth.isAuthenticated()) {
    return <Navigate to="/login" replace />
  }

  if (!auth.isAdmin()) {
    return <Navigate to="/" replace />
  }

  return <Outlet />
}

export default AdminRoute