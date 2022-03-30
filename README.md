# Framework
Task for Framework

mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml -Denvironment=dev clean test

Practical Task
Задача - построить фреймворк для автоматизации Hardcore задания из курса WebDriver.

Что должно быть в итоговом фреймворке:

1. webdrivermanager для управления коннекторам к браузерам.
2. Page Object / Page Factory для абстракций страниц.
3. Модель для бизнес-объектов необходимых сущностей.
4. properties файлы с тестовыми данным для разных окружений (как минимум 2).
5. xml suites для smoke тестов и всех тестов.
6. При падении теста должен быть сделан скриншот с датой и временем.
7. Фреймворк должен иметь возможность запуска с Jenkins и параметризацией браузера, тест suite, environment. Результаты 
   тестов должны быть на графике джобы, скриншоты должны быть заархивированных как артефакты.