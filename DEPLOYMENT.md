# Deployment Guide

This guide will walk you through deploying your Soccer Games Tracker to Railway (backend) and Vercel (frontend).

## Prerequisites

- GitHub account
- Railway account (sign up at https://railway.app)
- Vercel account (sign up at https://vercel.com)
- Your code pushed to a GitHub repository

---

## Part 1: Deploy Backend to Railway

### Step 1: Push Your Code to GitHub

If you haven't already:

```bash
cd /Users/o.penguin.h/Desktop/soccer-app-embed
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin YOUR_GITHUB_REPO_URL
git push -u origin main
```

### Step 2: Create a New Railway Project

1. Go to https://railway.app
2. Click **"New Project"**
3. Select **"Deploy from GitHub repo"**
4. Choose your `soccer-app-embed` repository
5. Railway will detect it's a monorepo - select the **`backend`** directory

### Step 3: Add PostgreSQL Database

1. In your Railway project dashboard, click **"+ New"**
2. Select **"Database"**
3. Choose **"PostgreSQL"**
4. Railway will automatically create the database and set the `DATABASE_URL` environment variable

### Step 4: Configure Environment Variables

Railway should automatically set `DATABASE_URL`. You need to add one more:

1. Click on your backend service
2. Go to the **"Variables"** tab
3. Add a new variable:
   - **Key**: `ALLOWED_ORIGINS`
   - **Value**: `https://your-app.vercel.app` (you'll update this after deploying frontend)

### Step 5: Set Root Directory

1. In your backend service, go to **"Settings"**
2. Find **"Root Directory"**
3. Set it to: `backend`
4. Click **"Save"**

### Step 6: Deploy

1. Railway will automatically deploy
2. Wait for the build to complete (check the **"Deployments"** tab)
3. Once deployed, click **"Settings"** → **"Networking"** → **"Generate Domain"**
4. **Save this URL** - you'll need it for the frontend!

Your backend URL will look like: `https://your-backend-production.up.railway.app`

---

## Part 2: Deploy Frontend to Vercel

### Step 1: Install Vercel CLI (Optional but recommended)

```bash
npm install -g vercel
```

### Step 2: Deploy to Vercel

**Option A: Using Vercel Website (Easier)**

1. Go to https://vercel.com
2. Click **"Add New..."** → **"Project"**
3. Import your GitHub repository
4. Vercel will detect it's a Vite app
5. Configure project:
   - **Framework Preset**: Vite
   - **Root Directory**: `frontend`
   - **Build Command**: `npm run build`
   - **Output Directory**: `dist`
6. Add Environment Variable:
   - **Key**: `VITE_API_URL`
   - **Value**: `https://your-backend-production.up.railway.app` (your Railway URL from Step 6 above)
7. Click **"Deploy"**

**Option B: Using CLI**

```bash
cd frontend
vercel
```

Follow the prompts:
- Link to existing project? **N**
- Project name: **soccer-app-embed**
- Directory: **./frontend**
- Override settings? **N**

Then set environment variable:

```bash
vercel env add VITE_API_URL
```

Paste your Railway backend URL when prompted, then redeploy:

```bash
vercel --prod
```

### Step 3: Update Railway CORS Settings

Now that you have your Vercel URL:

1. Go back to Railway
2. Click on your backend service
3. Go to **"Variables"** tab
4. Update `ALLOWED_ORIGINS` to your Vercel URL: `https://your-app.vercel.app`
5. Save (Railway will redeploy automatically)

---

## Testing Your Deployment

1. Visit your Vercel URL: `https://your-app.vercel.app`
2. The app should load and display the soccer tracker
3. Try clicking the arrows to increment/decrement the count
4. Verify the boxes change color correctly

---

## Troubleshooting

### Backend Issues

**Problem**: Backend won't start
- Check Railway logs: Go to your service → "Deployments" → Click latest deployment → "View Logs"
- Verify `DATABASE_URL` is set automatically by Railway
- Ensure Root Directory is set to `backend`

**Problem**: Database connection errors
- Make sure PostgreSQL database is created and running
- Check that `DATABASE_URL` environment variable exists

### Frontend Issues

**Problem**: Can't connect to backend
- Verify `VITE_API_URL` is set correctly in Vercel (no trailing slash)
- Check CORS: Make sure `ALLOWED_ORIGINS` in Railway includes your Vercel URL
- Open browser console (F12) to see network errors

**Problem**: Environment variable not working
- In Vercel, environment variables require a redeploy to take effect
- After adding/changing variables, click "Redeploy" in Vercel

### CORS Errors

If you see CORS errors in the browser console:

1. Go to Railway → Your backend service → "Variables"
2. Update `ALLOWED_ORIGINS` to include your Vercel URL
3. Format: `https://your-app.vercel.app` (no trailing slash)
4. Railway will automatically redeploy

---

## Summary of URLs

After deployment, save these URLs:

- **Backend (Railway)**: `https://your-backend-production.up.railway.app`
- **Frontend (Vercel)**: `https://your-app.vercel.app`
- **Database**: Managed automatically by Railway

---

## Embedding in Notion

Once deployed, to embed in Notion:

1. In Notion, type `/embed`
2. Paste your Vercel URL: `https://your-app.vercel.app`
3. Adjust the embed size (recommended: full width, ~400-500px height)
4. Your tracker will now appear in your Notion page!

---

## Need Help?

If you encounter issues:

1. Check Railway logs for backend errors
2. Check Vercel logs for frontend build errors
3. Use browser console (F12) to see network/CORS errors
4. Verify all environment variables are set correctly
