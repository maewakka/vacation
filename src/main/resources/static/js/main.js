// document.getElementById('login').addEventListener('click', () => {
//     window.location.href = "/oauth2/authorization/kakao"
// })

$('#login').click(() => {
    window.location.href = "/oauth2/authorization/kakao"
})

$('#logout').click(() => {
    window.location.href = '/logout'
})