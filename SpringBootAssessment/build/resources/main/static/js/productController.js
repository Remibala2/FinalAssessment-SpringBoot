//Doing a Product web app, in product page to
//display the name, description, imageUrl, style, price, ..., ...,.....,....


const createHTMLList = (id, title, description, date) =>
`
<table>
<tr>
<th>ID</th>
<th>TITLE</th>
<th>DESCRIPTION</th>
<th>DATE</th>

</tr>
<tr>
        <td id="id">${id}</td>
        <td id="title">${title}</td>
        <td id="description">${description}</td>
        <td id="date">${date}</td>

</tr>
</table>
`;

function displayProductDetails(item)
{
    document.querySelector("#title").innerText = item.title;
        document.querySelector("#description").innerText = item.description;
    document.querySelector("#date").innerText = item.date;

}


class ProductsController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the array
    addItem(id, title, description, date)
    {
        const itemObj = {
            oTitle: title,
            oDescription: description,
            oDate: date
        };

        this._items.push(itemObj);
    }

    addItem(title, description, date)
    {
       var productController = this;
       const formData = new FormData();
       formData.append('title', title);
       formData.append('description', description);
       formData.append('date', date);


       fetch('http://localhost:8080/item/add', {
      // fetch('https://rbwebproject.herokuapp.com/item/add',{
         method: 'POST',
         body: formData
         })
        .then(response => response.json())
        .then(data => {
        console.log('Success:', data);
        alert("Successfully added to Product")
        })
        .catch((error) => {
        console.error('Error:', error);
        alert("Error adding item to Product")
        });
    }

    displayItem()
    {
    var productController = this;
            productController._items = [];

            //fetch data from database using the REST API endpoint from Spring Boot
            fetch('http://127.0.0.1:8080/item/all')
        //  fetch('https://rbwebproject.herokuapp.com/item/all')
                .then((resp) => resp.json())
                .then(function(data) {
                  //  console.log("2. receive data")
                    console.log(data);
                    data.forEach(function (item, index) {

                        const itemObj = {
                            id: item.id,
                            title: item.title,
                            description: item.description,
                            date: item.date
                       };
                        productController._items.push(itemObj);

                  });

productController.renderProductPage();

                })
                .catch(function(error) {
                    console.log(error);
                });

    }
    renderProductPage()
    {
        var productHTMLList = [];

        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(item.id, item.title, item.description, item.date);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;


        //addEventListener - click
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];
            document.getElementById(i).addEventListener("click", function() { displayProductDetails(item);} );
        }
    }
}   //End of ProductsController class
