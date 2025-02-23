FROM node:20-alpine
WORKDIR /persona
COPY . .
RUN npm install
EXPOSE 5173
CMD [ "npm","run","dev" ]