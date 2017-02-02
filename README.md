# InterativaEstoque - Um Sistema de Cadastro de Itens em Estoque.

Este sistema é um cadastro de itens genéricos e controle de movimentação de estoque.

##1)Instalação:
###1.1) Instalar e configurar os respectivos softwares:
*Richfaces 3.3
*JBoss Seam 2.2
*EJB3
*JPA
*JBoss AS 5.1
*MySQL 5.7

###1.2)Criar a base de dados:
>>Criar a base de dados com base no dump estrutural “basededados.sql” que faz parte do projeto.
Este sistema foi desenvolvido com base no SGBD Mysql 5.7. Sendo assim, alterações no dump estrutural podem/devem ser necessárias para uso de SQBG diferente.

###1.3)Apontar o arquivo data source para a base de dados correta. (“InterativaEstoque-ds.xml”)
     <connection-url>jdbc:mysql://localhost:3306/interativa</connection-url>
      <driver-class>com.mysql</driver-class>
      <user-name>usuario</user-name>
      <password>senhadousuario</password>


##2)Configuração:

É fundamental configurar o sistema antes de iniciar o uso(cadastrar novos itens).

###2.1) Inserir “Tipos de Movimentação” utilizados no sistema.
>>Navegar pelo sistema até a janela “Lista de Tipos de movimentação” e adicionar os tipos:
*”Entrada”
*”Saída”

###2.2) Adicionar categorias de itens: (Ex: Automotivo, Eletrônicos, etc)
Categorias são atributos no cadastro de itens, por isso é preciso cadastrá-los antes.
>>Navegar até a janela “Lista de categorias” e cadastrar categorias.

###2.3) Adicionar modelos de itens: (Ex: Placa de vídeo NVIDIA GFORCE 7700, Caneta esferográfica azul BIC)
Modelos são atributos no cadastro de itens, por isso é preciso cadastrá-los antes.
>>Navegar até a janela “Lista de modelos” e cadastrar modelos.

##3) Forma de uso:

###3.1) Cadastro de Itens:
O cadastro de itens é feito através da janela “Lista de itens.”

###3.1.1)As propriedades dos itens são:
- Número de série;
- Modelo;
Categoria;

###3.2) Movimentação de itens:
A movimentação de itens é realizada através da janela “Lista de itens.” Nesta janela é realizada o registro de entrada e saída do ítem do estoque. 

####3.2.1)Cada item na lista desta janela possui um botão que indica a alteração do “Status” do item: “Em estoque”, “Fora de estoque”. 
Clicando neste botão você altera o status do item no estoque.

###3.3) Consultando movimentações:
Na janela Lista de movimentações é onde se encontram os registros de movimentação de itens.
As propriedades principais de uma movimentação são: número serial do item movimentado, modelo, categoria, data da movimentação e tipo de movimentação(entrada/saída).


##//TODO

Design de arquitetura:
- Melhor desacoplamento das classes de controller e de modelo
- Melhor desacoplamento da camada de controle e camada de view.

Funcionalidades
- Validação dos campos de criação e edição nos formulários;
- Controle de erros para preenchimento de campos nos formulários;
- Feedbacks adequados para cada situação de uso e de erro do sistema;
- Listagens paginadas;
- Login: os componentes foram criados, falta configurar e ativar;
- Filtros por tipo de atributos nas listagens;
- Melhor forma de configuração para o sistema, em vez de utilizar valores da base de dados;
- Criar mais dialogs para prevenir alteração de dados indesejadas.
- Corrigir navegação: após criação de determinado componente, redirecionar para respectiva lista.
