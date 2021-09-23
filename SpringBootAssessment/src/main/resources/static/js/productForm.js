
const productsControl = new ProductsController();
//let storeImage = ""

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newItemTitle = document.querySelector('#newItemTitle');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemDate = document.querySelector('#newItemTargetDate');


    // Get the values of the inputs - variable names to be same as MySQL columns
    const title = newItemTitle.value;
    const description = newItemDescription.value;
    const date = newItemTargetDate.value;

    // Clear the form
    newItemTitle.value = '';
    newItemDescription.value = '';

    newItemDate.value = '';

    // Add the task to the task manager
    productsControl.addItem(title, description, date);

});

// select file input
//const input = document.querySelector('#newItemImageFile');

// add event listener
input.addEventListener('change', () => {
//File object representing the file(s) selected by the user
    storeImage = input.files[0];
});