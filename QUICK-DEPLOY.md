# Quick Deployment Checklist

## 🚂 Railway (Backend) - 5 Steps

1. **Create Project**: Go to Railway → New Project → Deploy from GitHub → Select `soccer-app-embed`
2. **Add Database**: Click "+ New" → Database → PostgreSQL
3. **Set Root Directory**: Settings → Root Directory → `backend`
4. **Add Environment Variable**:
   - `ALLOWED_ORIGINS` = `https://your-vercel-app.vercel.app` (update after frontend deployed)
5. **Get URL**: Settings → Networking → Generate Domain → **Save this URL!**

## ▲ Vercel (Frontend) - 4 Steps

1. **Create Project**: Go to Vercel → New Project → Import from GitHub
2. **Configure**:
   - Root Directory: `frontend`
   - Framework: Vite
   - Build: `npm run build`
   - Output: `dist`
3. **Add Environment Variable**:
   - `VITE_API_URL` = `https://your-railway-backend.up.railway.app`
4. **Deploy** → **Save your Vercel URL!**

## 🔄 Final Step

Go back to Railway → Variables → Update `ALLOWED_ORIGINS` with your Vercel URL

## ✅ Test

Visit your Vercel URL and try clicking the arrows!

---

**Full guide with troubleshooting**: See [DEPLOYMENT.md](DEPLOYMENT.md)
