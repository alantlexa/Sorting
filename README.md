Программа производит сортировку слиянием переданных файлов с отсортированными числами, которые записаны в столбик.
Результатом работы программы является новый файл с объединенным содержимым входных файлов, отсортированным по возрастанию.
В случае если сортировка чисел в файлах не произведена заранее, программа сделает это сама.

Для того чтобы запустить обработку необходимо:

- Разместить входные файлы в той же директории что и текущая программа.
- Открыть командную строку, после чего указать путь к директории программы(cd C:\Users\User...).
- Далее необходимо передать аргументы:
	-a задает режим сортировки по возрастанию (аргумент не обязателен, этот параметр задается по умолчанию самой программой);
	-i тип данных (в данном случае означает int - целочисленное значение);
	"имя выходного файла".txt исходный отсортированный массив чисел;
	"имя вашего файла с числами".txt , данных файлов может быть указано сколько угодно.
