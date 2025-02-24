- Распечатайте полный путь к вашему домашнему каталогу
```bash
$ echo $HOME
/home/surelye
```

- Перейдите в домашний каталог
```bash
$ cd ~
```

- Получите все файлы в текущем каталоге
```bash
$ ls -a
.		  .dmrc		 .local		 .ssh				      .viminfo
..		  Documents	 .mozilla	 .sudo_as_admin_successful	      .wget-hsts
2_navigation.txt  Downloads	 .msf4		 Templates			      .Xauthority
.bash_logout	  .face		 Music		 .tmux.conf			      .xsession-errors
.bashrc		  .face.icon	 .mysql_history  .vboxclient-clipboard.pid	      .xsession-errors.old
.bashrc.original  .gnupg	 .npm		 .vboxclient-display-svga-x11.pid     .zsh_history
.cache		  .ICEauthority  payloads	 .vboxclient-draganddrop.pid	      .zshrc
.config		  .java		 Pictures	 .vboxclient-seamless.pid
.dbus		  .john		 .profile	 .vboxclient-vmsvga-session-tty7.pid
Desktop		  .lesshst	 Public		 Videos
```

- Создайте новую папку «test»
```bash
$ mkdir test
```

- Переименуйте папку «test» в «newTest»
```bash
$ mv test newTest
```

- Перейдите в папку «newTest»
```bash
$ cd newTest
```

- Получите текущую дату и сохраните результат в файл «nowFile»
```bash
$ date +"%d-%m-%Y" > nowFile
```

- Скопируйте файл «nowFile». Новое имя файла — «copyOfNowFile»
```bash
$ cp nowFile copyOfNowFile
```

- Получите информацию обо всех файлах (включая дату создания, автора и т. д.)
```bash
$ ls -al
total 16
drwxr-xr-x  2 surelye surelye 4096 Feb 20 10:24 .
drwx------ 23 surelye surelye 4096 Feb 20 10:23 ..
-rw-r--r--  1 surelye surelye   11 Feb 20 10:24 copyOfNowFile
-rw-r--r--  1 surelye surelye   11 Feb 20 10:24 nowFile
```

- Создайте пустой файл «emptyFile» без текстового редактора
```bash
$ touch emptyFile
```

- Вернитесь назад в домашний каталог
```bash
$ cd ..
```

- Удалите папку «newTest» с ее содержимым
```bash
$ rm -r newTest
```