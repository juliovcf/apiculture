###Imagen Docker###
docker run --name mi-postgres -e POSTGRES_DB=apiculture -e POSTGRES_USER=jperecab -e POSTGRES_PASSWORD=laboratorio -p 5432:5432 -d postgres
