# Soccer Games Tracker - Notion Embed

A full-stack application to track the number of soccer games watched, designed to be embedded in Notion pages.

## Project Structure

- `backend/` - Spring Boot backend (H2 for local dev, PostgreSQL for production)
- `frontend/` - React frontend built with Vite

## Backend Setup

### Prerequisites
- Java 17 or higher
- Maven

### Running Locally

The backend uses H2 in-memory database by default, so no database setup is required for local development.

1. Navigate to the backend directory:
```bash
cd backend
```

2. Run the application:
```bash
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

**Note:** The H2 console is available at `http://localhost:8080/h2-console` for database inspection during development.

### API Endpoints

- `GET /api/games` - Get all games watched
- `POST /api/games` - Add a new game watched
- `GET /api/games/count` - Get monthly and total count
- `GET /api/games/count/monthly?month=X&year=Y` - Get count for specific month

### Deploying to Railway

1. Create a new project on Railway
2. Add a PostgreSQL database service
3. Deploy the backend - Railway will automatically set the `DATABASE_URL` environment variable
4. Set the `ALLOWED_ORIGINS` environment variable to your frontend URL

**Note:** When `DATABASE_URL` is provided (as Railway does automatically), the application switches from H2 to PostgreSQL. No code changes needed!

## Frontend Setup

### Prerequisites
- Node.js 18+ and npm

### Running Locally

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

The frontend will start on `http://localhost:5173`

### Building for Production

```bash
npm run build
```

The build output will be in the `dist/` directory.

## Notion Embed

To embed this in a Notion page:

1. Deploy your frontend (e.g., Vercel, Netlify)
2. Deploy your backend to Railway
3. In Notion, use the `/embed` command
4. Paste your frontend URL
5. Adjust the embed size as needed

## Features

- Track soccer games watched
- Display monthly count
- Visual chart representation
- H2 in-memory database for local development
- PostgreSQL database for production persistence
- Designed for Notion page embedding
- Zero database setup required for local development
