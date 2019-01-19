local_image_name=dummy-esight
local_container_name=local-esight
docker stop $local_container_name
docker rm $local_container_name

docker build -t $local_image_name .
docker run -dit -p 32102:32102 --name $local_container_name $local_image_name
