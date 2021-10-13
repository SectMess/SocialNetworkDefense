package com.astute.socialnetworkdefense.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.astute.socialnetworkdefense.R
import com.astute.socialnetworkdefense.presentation.components.StandardTextField
import com.astute.socialnetworkdefense.presentation.login.LoginViewModel
import com.astute.socialnetworkdefense.presentation.ui.theme.*
import com.astute.socialnetworkdefense.util.Constants

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 60.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = SpaceMedium),
        ) {
            Text(
                text = stringResource(R.string.register_new_account),
                style = MaterialTheme.typography.h1,
            )
            Spacer(modifier = Modifier.height(SpaceSmall))

            //Email Field
            StandardTextField(
                text = state.emailText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredEmail(it))
                },
                error = when (state.emailError) {
                    RegisterState.EmailError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterState.EmailError.InvalidEmail -> {
                        stringResource(id = R.string.not_a_valid_email)
                    }
                    null -> ""
                },
                keyboardType = KeyboardType.Email,
                hint = stringResource(R.string.email_hint),
            )
            Spacer(modifier = Modifier.height(SpaceMedium))

            //Username Field
            StandardTextField(
                text = state.usernameText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredUsername(it))
                },
                error = when (state.usernameError) {
                    RegisterState.UsernameError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterState.UsernameError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_USERNAME_LENGTH)
                    }
                    null -> ""
                },
                hint = stringResource(R.string.login_hint),
            )
            Spacer(modifier = Modifier.height(SpaceMedium))



            //Password field
            StandardTextField(
                text = state.passwordText,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredPassword(it))
                },
                hint = stringResource(R.string.password_hint),
                keyboardType = KeyboardType.Password,
                error = when (state.passwordError) {
                    RegisterState.PasswordError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    RegisterState.PasswordError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_PASSWORD_LENGTH)
                    }
                    RegisterState.PasswordError.InvalidPassword -> {
                        stringResource(id = R.string.invalid_password)
                    }
                    null -> ""
                },
                isPasswordVisible = state.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(RegisterEvent.TogglePasswordVisibility)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))

            //Login Button
            Button(
                onClick = {
                    viewModel.onEvent(RegisterEvent.Register)
                },
                modifier = Modifier.align(Alignment.End)
            ){
                Text(
                    text = stringResource(R.string.register),
                    color = MaterialTheme.colors.onPrimary
                )
            }

        }

        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.alread_have_account))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_in)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(signUpText)
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }

        )
    }
}