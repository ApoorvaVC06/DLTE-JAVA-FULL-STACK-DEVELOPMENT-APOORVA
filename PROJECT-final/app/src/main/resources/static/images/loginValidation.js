// $(document).ready(()=> {
//     $('#user').on('input', function () {
//         console.log("Entered the valid username");
//         var username = $(this).val();
//         var validUserName = /^[a-z]{3,}$/;
//         if (username.length === 0) {
//             $('.user').addClass('invalid-msg').text("username is required!!");
//             $(this).addClass('invalid-input').removeClass('valid-input');
//
//         } else if (!validUserName.test(username)) {
//             $('.user').addClass('invalid-msg').text('username must atleast 4 characters!!');
//             $(this).addClass('invalid-input').removeClass('valid-input');
//
//         } else {
//             $('.user').empty();
//             $(this).addClass('valid-input').removeClass('invalid-input');
//         }
//     });
//     $('#pass').on('input', function () {
//         console.log("Entered the valid password");
//         var password = $(this).val();
//         var validPassword = /^[a-z]{4,}[0-9]{3}$/;
//         if (password.length === 0) {
//             $('.password').addClass('invalid-msg').text("username is required!!");
//             $(this).addClass('invalid-input').removeClass('valid-input');
//
//         } else if (!validPassword.test(password)) {
//             $('.password').addClass('invalid-msg').text('password must contain atleast 4 characters and 3 numbers!!');
//             $(this).addClass('invalid-input').removeClass('valid-input');
//
//         } else {
//             $('.password').empty();
//             $(this).addClass('valid-input').removeClass('invalid-input');
//         }
//     });
// })