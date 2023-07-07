function copyFrom(src) {
    return function () {
        let codeBlock = this.parentNode.parentNode;
        let commandText = codeBlock.querySelector(src).innerText;

        let tempInput = document.createElement('input');
        tempInput.value = commandText;
        document.body.appendChild(tempInput);

        tempInput.select();
        document.execCommand('copy');

        document.body.removeChild(tempInput);
        this.classList.add("block__code-copy--copied");

        setTimeout(() => {
            this.classList.remove("block__code-copy--copied")
        }, 1350)

        // this.innerHTML = '<img src="images/copied.svg" alt="copy">';
    }
}


const copyButtons = document.querySelectorAll('.block__code-copy');
copyButtons.forEach(button => button.addEventListener('click', copyFrom('.block__code-text .block__code-command')))