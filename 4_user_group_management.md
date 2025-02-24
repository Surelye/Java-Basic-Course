- Распечатайте текущего пользователя
```bash
$ whoami
surelye
```

- Измените свой пароль
```bash
$ passwd
Changing password for surelye.
Current password: 
New password: 
Retype new password: 
passwd: password updated successfully
```

- Добавьте новых пользователей «readUser» и «editUser»
```bash
$ sudo su
[sudo] password for surelye: 

# useradd -d /home/readUser readUser
# useradd -d /home/editUser editUser
```

- Добавьте новые группы «readers» и «editors»
```bash
# groupadd readers
# groupadd editors
```

- Добавьте пользователя «readUser» в группу «readers» и «editUser» в группу «editors»
```bash
# usermod -aG readers readUser
# usermod -aG editors editUser
```

- Создайте «read» и «edit» каталоги с любыми файлами внутри (это могут быть файлы из предыдущих задач)
```bash
# mkdir -p /home/readUser/read /home/editUser/edit
# echo "Read File" > /home/readUser/read/file1.txt
# echo "Edit File" > /home/editUser/edit/file2.txt
```

- Предоставьте группам права доступа к каталогам (доступ только на чтение для группы «readers» к каталогу «read» и полный доступ для группы «editors» к каталогу «edit»)
```bash
# chown -R :readers /home/readUser/read
# chmod -R g=r /home/readUser/read
# ls -al /home/readUser/read
total 12
drwxr--r-x 2 root readers 4096 Feb 24 12:31 .
drwxr-xr-x 3 root root    4096 Feb 24 12:31 ..
-rw-r--r-- 1 root readers   10 Feb 24 12:31 file1.txt

# chown -R :editors /home/editUser/edit
# chmod -R g=rwx /home/editUser/edit
# ls -al /home/editUser/edit
total 12
drwxrwxr-x 2 root editors 4096 Feb 24 12:31 .
drwxr-xr-x 3 root root    4096 Feb 24 12:31 ..
-rw-rwxr-- 1 root editors   10 Feb 24 12:31 file2.txt
```

- Попробуйте переключаться между пользователями и читать информацию из файлов
```bash
# su readUser
$ whoami
readUser
$ ls -al /home/readUser/read
ls: cannot access '/home/readUser/read/.': Permission denied
ls: cannot access '/home/readUser/read/file1.txt': Permission denied
ls: cannot access '/home/readUser/read/..': Permission denied
total 0
d????????? ? ? ? ?            ? .
d????????? ? ? ? ?            ? ..
-????????? ? ? ? ?            ? file1.txt
$ cat /home/readUser/read/file1.txt
cat: /home/readUser/read/file1.txt: Permission denied
$ ls -al /home/editUser/edit
total 12
drwxrwxr-x 2 root editors 4096 Feb 24 12:31 .
drwxr-xr-x 3 root root    4096 Feb 24 12:31 ..
-rw-rwxr-- 1 root editors   10 Feb 24 12:31 file2.txt
$ cat /home/editUser/edit/file2.txt
Edit File
$ exit
```

- Переключимся на другого пользователя и попробуем прочитать файлы
```bash
# su editUser
$ whoami
editUser
$ ls -al /home/readUser/read
total 12
drwxr--r-x 2 root readers 4096 Feb 24 12:31 .
drwxr-xr-x 3 root root    4096 Feb 24 12:31 ..
-rw-r--r-- 1 root readers   10 Feb 24 12:31 file1.txt
$ cat /home/readUser/read/file1.txt
Read File
$ ls -al /home/editUser/edit
total 12
drwxrwxr-x 2 root editors 4096 Feb 24 12:31 .
drwxr-xr-x 3 root root    4096 Feb 24 12:31 ..
-rw-rwxr-- 1 root editors   10 Feb 24 12:31 file2.txt
$ cat /home/editUser/edit/file2.txt
Edit File
```