FROM node:18-alpine

WORKDIR /app
COPY package.json ./
COPY package-lock.json ./
RUN npm install

COPY . .
RUN npm run build

# Use nginx to serve the static files
FROM nginx:alpine
COPY --from=0 /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
