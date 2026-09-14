# Gerando testes unitarios com o Randoop

```bash
cd sistemavendas
mvn clean package
java -Xmx3000m -classpath ./randoop-all-4.3.3.jar:./target/classes randoop.main.Main gentests --testclass=com.seubone.sistemavendas.model.Produto --output-limit=100 --junit-output-dir=./src/test/java/com/seubone/sistemavendas --test-package=com.seubone.sistemavendas
```