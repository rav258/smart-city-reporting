# Smart City Reporting System

<div align="center">

# 🏙️ Smart City Reporting System

A collaborative full-stack web application for reporting, managing, and analyzing city infrastructure issues such as potholes, broken street lights, graffiti, rubbish, and damaged road signs.

Built as a **student team project** with a modular architecture that supports collaboration between around **5 developers** using GitHub issues, branches, and pull requests.

![Quarkus](https://img.shields.io/badge/backend-Quarkus-blue)
![React](https://img.shields.io/badge/frontend-React-61dafb)
![TypeScript](https://img.shields.io/badge/language-TypeScript-3178c6)
![Java](https://img.shields.io/badge/language-Java-orange)
![MySQL](https://img.shields.io/badge/database-MySQL-4479a1)
![Flyway](https://img.shields.io/badge/migrations-Flyway-cc0200)
![Status](https://img.shields.io/badge/status-In%20Development-yellow)

</div>

---

## Table of Contents

- [Overview](#overview)
- [Project Goals](#project-goals)
- [Main Features](#main-features)
- [Technology Stack](#technology-stack)
- [System Architecture](#system-architecture)
- [Project Structure](#project-structure)
- [Backend Modules](#backend-modules)
- [Frontend Features](#frontend-features)
- [User Roles](#user-roles)
- [Report Lifecycle](#report-lifecycle)
- [Database and Migrations](#database-and-migrations)
- [API Overview](#api-overview)
- [Getting Started](#getting-started)
- [Environment Configuration](#environment-configuration)
- [Development Workflow](#development-workflow)
- [Coding Guidelines](#coding-guidelines)
- [MVP Scope](#mvp-scope)
- [Future Improvements](#future-improvements)
- [Team Structure](#team-structure)
- [License](#license)

---

## Overview

The **Smart City Reporting System** is a web-based platform that allows citizens to report public infrastructure issues and enables administrators to manage those reports efficiently.

The system is designed to:
- improve communication between citizens and city management,
- centralize issue reporting,
- support structured status tracking,
- provide dashboard analytics,
- and encourage collaborative software development in a team environment.

This project is especially suitable as a **student group project** because it combines:
- backend development,
- frontend development,
- database design,
- authentication and authorization,
- analytics,
- and team-based Git workflows.

---

## Project Goals

The main objective of this project is to create a modern web application that simplifies the reporting and management of city issues.

### Primary goals
- Allow users to register and log in securely
- Allow citizens to submit issue reports
- Categorize and organize reports by type and district
- Track status and priority of each report
- Provide an admin panel for report management
- Visualize issue data through summary dashboards
- Support collaborative development using GitHub

---

## Main Features

### Citizen Features
- User registration and login
- Create a new city issue report
- Add title and description
- Select category and district
- Provide issue location coordinates
- Browse report list
- View report details
- Add comments to reports
- Upload attachments or images

### Admin Features
- Review all submitted reports
- Change report status
- Update report priority
- Manage report lifecycle
- View dashboard summaries and analytics
- Monitor report distribution by category and district

### Dashboard Features
- Total reports summary
- Reports grouped by status
- Reports grouped by category
- Reports grouped by district
- Geographic map/heatmap support for issue locations

---

## Technology Stack

### Backend
- **Quarkus**
- **Java**
- **Maven**
- **REST API**
- **Hibernate ORM / JPA**
- **MySQL**
- **Flyway**
- **JWT Authentication**

### Frontend
- **React**
- **TypeScript**
- **Vite**
- **React Router**
- **Axios**

### DevOps / Collaboration
- **Docker**
- **Docker Compose**
- **GitHub**
- **GitHub Issues**
- **Pull Requests**

---

## System Architecture

The application follows a classic full-stack architecture with a separate backend and frontend.

```text
+-------------------+         HTTP / JSON         +----------------------+
|   React Frontend  |  <----------------------->  |   Quarkus Backend    |
|   (TypeScript)    |                             |   REST API           |
+-------------------+                             +----------------------+
                                                             |
                                                             |
                                                             v
                                                    +------------------+
                                                    |  MySQL Database  |
                                                    |  + Flyway        |
                                                    +------------------+
```

### Architectural principles
- clear separation between frontend and backend,
- modular backend structure by feature,
- versioned database schema through Flyway,
- REST-based communication,
- scalable team collaboration through issue-based development.

---

## Project Structure

```text
smart-city-reporting/
│
├── backend/                 # Quarkus REST API
├── frontend/                # React application
├── docs/                    # project documentation
├── scripts/                 # helper scripts
├── docker-compose.yml       # local development services
├── .gitignore
└── README.md
```

### Backend structure

```text
backend/
├── src/main/java/com/smartcity/reporting/
│   ├── common/
│   ├── security/
│   ├── user/
│   ├── report/
│   ├── category/
│   ├── district/
│   ├── comment/
│   ├── attachment/
│   ├── dashboard/
│   ├── admin/
│   └── SmartCityApplication.java
│
├── src/main/resources/
│   ├── application.properties
│   └── db/migration/
│
├── pom.xml
└── Dockerfile
```

### Frontend structure

```text
frontend/
├── src/
│   ├── api/
│   ├── app/
│   ├── components/
│   ├── features/
│   ├── hooks/
│   ├── layouts/
│   ├── pages/
│   ├── routes/
│   ├── types/
│   ├── utils/
│   ├── App.tsx
│   └── main.tsx
│
├── package.json
└── Dockerfile
```

---

## Backend Modules

- `security` — authentication, JWT, authorization
- `user` — user and role management
- `report` — issue reports and report lifecycle
- `category` — issue categories
- `district` — city districts
- `comment` — report comments
- `attachment` — uploaded files and images
- `dashboard` — aggregated statistics and analytics
- `admin` — admin-only management endpoints
- `common` — shared utilities, exception handling, validation

---

## Frontend Features

- `auth`
- `reports`
- `comments`
- `attachments`
- `dashboard`
- `admin`

Each feature can be developed independently, which makes the project suitable for multi-developer collaboration.

---

## User Roles

### Citizen
Can:
- register and log in,
- create reports,
- browse reports,
- view report details,
- add comments,
- upload attachments.

### Admin
Can:
- access admin pages,
- update report status,
- update report priority,
- manage submitted reports,
- view dashboards and analytics.

### Optional future roles
- `WORKER`
- `MODERATOR`

---

## Report Lifecycle

### Example status flow
- `NEW`
- `IN_PROGRESS`
- `RESOLVED`
- `REJECTED`

### Example priority levels
- `LOW`
- `MEDIUM`
- `HIGH`

The report lifecycle should be stored with history so changes are traceable.

---

## Database and Migrations

The project uses **MySQL** as the primary relational database and **Flyway** for schema versioning.

### Planned core tables
- `user`
- `role`
- `user_role`
- `category`
- `district`
- `report`
- `status_history`
- `comment`
- `attachment`

### Migration location
```text
backend/src/main/resources/db/migration/
```

### Example migration naming
```text
V1__create_user_and_role_tables.sql
V2__create_category_and_district_tables.sql
V3__create_report_table.sql
V4__create_comment_and_attachment_tables.sql
V5__create_status_history_table.sql
```

---

## API Overview

### Authentication
- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/auth/me`

### Reports
- `GET /api/reports`
- `GET /api/reports/{id}`
- `POST /api/reports`

### Categories
- `GET /api/categories`

### Districts
- `GET /api/districts`

### Comments
- `GET /api/reports/{id}/comments`
- `POST /api/reports/{id}/comments`

### Attachments
- `POST /api/reports/{id}/attachments`
- `GET /api/reports/{id}/attachments`

### Dashboard
- `GET /api/dashboard/summary`
- `GET /api/dashboard/by-status`
- `GET /api/dashboard/by-category`
- `GET /api/dashboard/by-district`

### Admin
- `GET /api/admin/reports`
- `PUT /api/admin/reports/{id}/status`
- `PUT /api/admin/reports/{id}/priority`

---

## Getting Started

### Prerequisites

Make sure the following tools are installed:
- Java 17+ or the version required by Quarkus
- Maven
- Node.js
- npm
- Docker
- Docker Compose

---

## Running with Docker Compose

From the project root directory:

```bash
docker-compose up --build
```

This should start:
- MySQL database
- backend application
- frontend application

### Example ports
- frontend: `http://localhost:5173`
- backend: `http://localhost:8080`
- MySQL: `localhost:3306`

Adjust ports if your Docker configuration uses different values.

---

## Running Backend Locally

Move to the backend directory:

```bash
cd backend
```

Run Quarkus in development mode:

```bash
./mvnw quarkus:dev
```

On Windows:

```bash
mvnw.cmd quarkus:dev
```

The backend should be available at:

```text
http://localhost:8080
```

---

## Running Frontend Locally

Move to the frontend directory:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend should be available at:

```text
http://localhost:5173
```

---

## Environment Configuration

### Backend configuration

Backend configuration is stored in:

```text
backend/src/main/resources/application.properties
```

Example:

```properties
quarkus.datasource.db-kind=mysql
quarkus.datasource.username=smartcity
quarkus.datasource.password=smartcity
quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/smart_city_reporting?useSSL=false&serverTimezone=UTC

quarkus.flyway.migrate-at-start=true
quarkus.flyway.locations=db/migration
quarkus.hibernate-orm.database.generation=none
```

### Frontend configuration

Frontend environment variables can be stored in:

```text
frontend/.env
```

Example:

```env
VITE_API_BASE_URL=http://localhost:8080
```

---

## Development Workflow

This project is intended for a team of around **5 developers**, so a consistent Git workflow is important.

### Main branches
- `main`
- `develop`

### Feature branches
- `feature/auth-module`
- `feature/report-module`
- `feature/dashboard-module`
- `feature/admin-module`
- `feature/comments-module`

### Recommended workflow
1. Create a new branch from `develop`
2. Work on a single issue or task
3. Commit changes with clear commit messages
4. Open a pull request into `develop`
5. Request review from another collaborator
6. Merge after approval

### Branch naming convention
```text
feature/<short-description>
fix/<short-description>
chore/<short-description>
docs/<short-description>
```

Examples:
```text
feature/auth-api
feature/report-list-page
fix/login-validation
docs/readme-update
```

---

## Commit Message Examples

```text
feat: add login endpoint
feat: implement report creation form
fix: correct JWT authentication handling
docs: update project setup guide
refactor: simplify report mapper
```

---

## Coding Guidelines

### Backend
- Keep business logic in `service`
- Keep REST endpoints in `resource`
- Use DTOs for API communication
- Do not expose entities directly
- Use structured exception handling
- Create Flyway migrations for every schema change

### Frontend
- Keep reusable UI in `components`
- Keep feature-specific logic in `features`
- Use typed API models
- Separate layout logic from page logic
- Handle loading, empty, and error states consistently

### General
- Prefer small, focused classes and components
- Use consistent naming
- Avoid overly large files
- Write readable code
- Document non-obvious design decisions

---

## MVP Scope

The first working version should include:
- user registration and login,
- report creation,
- report list,
- report details,
- category and district support,
- admin status updates,
- simple dashboard statistics.

---

## Future Improvements

Potential future enhancements:
- interactive city map,
- geolocation picker,
- email notifications,
- report assignment to workers,
- attachment preview gallery,
- advanced search and filtering,
- audit logging,
- mobile responsiveness improvements,
- public dashboard view.

---

## Team Structure

Example team distribution:

- **Developer 1** — backend security and users
- **Developer 2** — backend reports and database
- **Developer 3** — frontend auth and shared UI
- **Developer 4** — frontend reports and dashboard
- **Developer 5** — DevOps, documentation, integration, admin panel

This structure maps well to your GitHub issue setup and reduces merge conflicts by separating ownership by feature area.

---

## License

This project is created for **educational purposes** as a student collaboration project.

You can replace this section with a formal license later, for example:
- MIT
- Apache-2.0

---

## Status

**Project status:** In development
