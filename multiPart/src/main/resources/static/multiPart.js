const plusButton = document.getElementById('plus-btn');

if(plusButton){
    plusButton.addEventListener('click', () => {
        let divElement = document.createElement('div');
        let inputElement = document.createElement('input');
        inputElement.setAttribute('type', 'file');
        inputElement.setAttribute('name', 'files');

        document.getElementById('fileForm').insertBefore(divElement, document.getElementById('plus-btn'));
        divElement.appendChild(inputElement);
    });
}