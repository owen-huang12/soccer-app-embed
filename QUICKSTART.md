# Quick Start Guide

## What Was Fixed

The project has been configured to use **H2 in-memory database** for local development instead of PostgreSQL, so you don't need to install or configure any database to get started!

## Current Status

✅ Backend is running on `http://localhost:8080`
✅ H2 database initialized
✅ API endpoints working

## Start the Frontend

In a new terminal window:

```bash
cd frontend
npm run dev
```

The frontend will start on `http://localhost:5173`

## Test the Application

1. Open your browser to `http://localhost:5173`
2. You should see your soccer tracker component
3. Currently showing 0 games watched (since the database is empty)

## Add Test Data

You can add a game to test the counter:

```bash
curl -X POST http://localhost:8080/api/games \
  -H "Content-Type: application/json" \
  -d '{"gameTitle": "Test Game", "notes": "Test"}'
```

Then refresh the frontend to see the count update!

## Next Steps

1. Start building out the features you mentioned
2. When ready to deploy:
   - Deploy backend to Railway (will automatically use PostgreSQL)
   - Deploy frontend to Vercel/Netlify
   - Embed in Notion page

## Development Tips

- Backend: The H2 database resets every time you restart the server (it's in-memory)
- Frontend: Hot reload is enabled, changes will update automatically
- H2 Console: Visit `http://localhost:8080/h2-console` to inspect the database
  - JDBC URL: `jdbc:h2:mem:soccerapp`
  - Username: `sa`
  - Password: (leave empty)
