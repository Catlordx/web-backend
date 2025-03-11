数据库的Docker启动脚本
```shell 
docker run --name mysql-dev \
                                       -v ~/data/mysql:/var/lib/mysql \
                                       -p 3307:3306 \
                                       -e MYSQL_ROOT_PASSWORD=jkl123 \
                                       -d mysql:latest
```
