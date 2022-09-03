# YandexContestInternsDay
## FullGraph
Полная реализация взвешенного направленного графа на основе ArrayList. Из-за реализации на списке выполняется дольше
## Solution
Логическое решение задачи через HashMap. Выполняется быстрее
# Задание
<div class="problem-statement">
   <div class="header">
      <h1 class="title">A. Граф подстрок</h1>
      <table>
         <tr class="time-limit">
            <td class="property-title">Ограничение времени</td>
            <td>6&nbsp;секунд</td>
         </tr>
         <tr class="memory-limit">
            <td class="property-title">Ограничение памяти</td>
            <td>512Mb</td>
         </tr>
         <tr class="input-file">
            <td class="property-title">Ввод</td>
            <td colspan="1">стандартный ввод или input.txt</td>
         </tr>
         <tr class="output-file">
            <td class="property-title">Вывод</td>
            <td colspan="1">стандартный вывод или output.txt</td>
         </tr>
      </table>
   </div>
   <h2></h2>
   <div class="legend"> В свой первый рабочий день стажер Слава решил как следует изучить офис. Бродя по коридорам, Слава начал смотреть на английские
      названия переговорок. <!--l. 49-->
      <p style="text-indent: 0em;">Вскоре он заметил, что названия переговорок имеют некий дисбаланс в буквосочетаниях - неужели
      в Яндексе изобрели какой-то свой диалект английского языка? Славу очень заинтересовала эта тема, поэтому он решил построить
      модель буквосочетаний и изучить его. <!--l. 51-->
      </p><p style="text-indent: 0em;">Первым делом данную модель необходимо построить. Слава выбрал формат графа: </p><ul>
      <li>название переговорки <!--l. 54--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi>
      <mo>=</mo> <msub><mrow><mi>s</mi></mrow><mrow><mn>1</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mn>2</mn></mrow></msub><mo>…</mo><msub><mrow><mi>s</mi></mrow><mrow><mi>n</mi><mo>−</mo><mn>1</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mi>n</mi></mrow></msub></math>
      образует <!--l. 54--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>n</mi>
      <mo>−</mo> <mn>2</mn></math> буквосочетания длины 3: <!--l. 54--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mn>1</mn></mrow></msub>
      <mo>=</mo> <msub><mrow><mi>s</mi></mrow><mrow><mn>1</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mn>2</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mn>3</mn></mrow></msub></math>,
      <!--l. 54--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mn>2</mn></mrow></msub>
      <mo>=</mo> <msub><mrow><mi>s</mi></mrow><mrow><mn>2</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mn>3</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mn>4</mn></mrow></msub></math>,
      <!--l. 54--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mn>3</mn></mrow></msub>
      <mo>=</mo> <msub><mrow><mi>s</mi></mrow><mrow><mn>3</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mn>4</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mn>5</mn></mrow></msub></math>
      …<!--l. 54--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mi>n</mi><mo>−</mo><mn>2</mn></mrow></msub>
      <mo>=</mo> <msub><mrow><mi>s</mi></mrow><mrow><mi>n</mi><mo>−</mo><mn>2</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mi>n</mi><mo>−</mo><mn>1</mn></mrow></msub><msub><mrow><mi>s</mi></mrow><mrow><mi>n</mi></mrow></msub></math>;
      </li>
      <li>если для какого-то из буквосочетаний <!--l. 55--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mi>i</mi></mrow></msub></math>
      еще нет вершины в графе, то она создается; </li>
      <li>для каждой пары буквосочетаний <!--l. 56--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mrow><mo>(</mo><mrow><msub><mrow><mi>w</mi></mrow><mrow><mi>i</mi></mrow></msub><mo>,</mo><msub><mrow><mi>w</mi></mrow><mrow><mi>i</mi><mo>+</mo><mn>1</mn></mrow></msub></mrow><mo>)</mo></mrow></math>
      добавляется ориентированное ребро веса 1, или увеличивается вес существующего ребра на 1.</li>
      </ul>
      <!--l. 60-->
      <p style="text-indent: 0em;">Таким образом получается граф <!--l. 60--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>G</mi></math>
      с <!--l. 60--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>v</mi></math>
      вершинами и <!--l. 60--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>e</mi></math>
      ориентированными ребрами. Между некоторыми вершинами может быть несколько дуг (от <!--l. 60--><math display="inline" style="text-indent:
      0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>a</mi></math> к <!--l. 60--><math display="inline" style="text-indent:
      0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>b</mi></math> и от <!--l. 60--><math display="inline" style="text-indent:
      0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>b</mi></math> к <!--l. 60--><math display="inline" style="text-indent:
      0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>a</mi></math>). <!--l. 62-->
      </p><p style="text-indent: 0em;">Помогите Славе по заданному набору названий переговорок найти количество вершин в получившемся
      графе и вывести ориентированные ребра между вершинами. </p>
      <p></p>
      <p></p>
      <p></p>
      
   </div>
   <h2>Формат ввода</h2>
   <div class="input-specification"> В первой строке записано одно целое число <!--l. 65--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi></math>
      (<!--l. 65--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn> <mo>≤</mo>
      <mi>T</mi> <mo>≤</mo> <mn>4</mn><mn>0</mn><mspace width="0.3em"><mn>0</mn><mn>0</mn><mn>0</mn></mspace></math>)&nbsp;— количество
      переговорок, которые встретил Слава по пути к рабочему месту. <!--l. 67-->
      <p style="text-indent: 0em;">В каждой из <!--l. 67--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi></math>
      следующих строк записано одно название переговорки <!--l. 67--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>S</mi></mrow><mrow><mi>i</mi></mrow></msub></math>
      (<!--l. 67--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mn>4</mn> <mo>≤</mo><mo>|</mo><msub><mrow><mi>S</mi></mrow><mrow><mi>i</mi></mrow></msub><mo>|</mo><mo>≤</mo>
      <mn>3</mn><mn>0</mn></math>). Все названия состоят из строчных букв английского алфавита. </p>
      
   </div>
   <h2>Формат вывода</h2>
   <div class="output-specification"> В первой строке выведите количество вершин <!--l. 71--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>v</mi></math>
      в графе <!--l. 71--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>G</mi></math>.
      <!--l. 73-->
      <p style="text-indent: 0em;">Во второй строке выведите количество пар вершин <!--l. 73--><math display="inline" style="text-indent:
      0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>e</mi></math>, между которыми есть ориентированные ребра. <!--l. 75-->
      </p><p style="text-indent: 0em;">В каждой из следующих <!--l. 75--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><mi>e</mi></math>
      строк выведите слово <!--l. 75--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mi>s</mi></mrow></msub></math>,
      соответствующее началу ребра, затем слово <!--l. 75--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mi>f</mi></mrow></msub></math>,
      соответствующее концу ребра, и вес ориентированного ребра из вершины <!--l. 75--><math display="inline" style="text-indent:
      0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mi>s</mi></mrow></msub></math> в <!--l.
      75--><math display="inline" style="text-indent: 0em;" xmlns="http://www.w3.org/1998/Math/MathML"><msub><mrow><mi>w</mi></mrow><mrow><mi>f</mi></mrow></msub></math>.
      <!--l. 77-->
      </p><p style="text-indent: 0em;">Ребра вы можете перечислить в произвольном порядке. </p>
      <p></p>
      <p></p>
      
   </div>
   <h3>Пример 1</h3>
   <table class="sample-tests">
      <thead>
         <tr>
            <th>Ввод</th>
            <th>Вывод</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td><pre>2
aaaaaaaaaaaaa
aaabbbaaabbba
</pre></td>
            <td><pre>6
7
aaa aaa 10
aaa aab 2
aab abb 2
abb bbb 2
bbb bba 2
bba baa 1
baa aaa 1
</pre></td>
         </tr>
      </tbody>
   </table>
   <h3>Пример 2</h3>
   <table class="sample-tests">
      <thead>
         <tr>
            <th>Ввод</th>
            <th>Вывод</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td><pre>2
abab
baba
</pre></td>
            <td><pre>2
2
aba bab 1
bab aba 1
</pre></td>
         </tr>
      </tbody>
   </table>
   <h3>Пример 3</h3>
   <table class="sample-tests">
      <thead>
         <tr>
            <th>Ввод</th>
            <th>Вывод</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td><pre>1
qwertyqwertyqwertyqwertyqwerty
</pre></td>
            <td><pre>6
6
qwe wer 5
wer ert 5
ert rty 5
rty tyq 4
tyq yqw 4
yqw qwe 4
</pre></td>
         </tr>
      </tbody>
   </table>
