package com.astute.socialnetworkdefense.feature_auth.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.astute.socialnetworkdefense.presentation.ui.theme.*
import com.astute.socialnetworkdefense.core.util.Constants
import com.astute.socialnetworkdefense.core.presentation.util.UiEvent
import com.astute.socialnetworkdefense.core.util.asString
import com.astute.socialnetworkdefense.feature_auth.presentation.util.AuthError
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: RegisterViewModel = hiltViewModel(),
) {
    val usernameState = viewModel.usernameState.value
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val registerState = viewModel.registerState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is UiEvent.SnackbarEvent -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.uiText.asString(context),
                        duration = SnackbarDuration.Long
                    )
                }
            }
        }
    }

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
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredEmail(it))
                },
                error = when (emailState.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.error_field_empty)
                    }
                    is AuthError.InvalidEmail -> {
                        stringResource(id = R.string.not_a_valid_email)
                    }
                    else -> ""
                },
                keyboardType = KeyboardType.Email,
                hint = stringResource(R.string.email_hint),
            )
            Spacer(modifier = Modifier.height(SpaceMedium))

            //Username Field
            StandardTextField(
                text = usernameState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredUsername(it))
                },
                error = when (viewModel.usernameState.value.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.error_field_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_USERNAME_LENGTH)
                    }
                    else -> ""
                },
                hint = stringResource(R.string.login_hint),
            )
            Spacer(modifier = Modifier.height(SpaceMedium))



            //Password field
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(RegisterEvent.EnteredPassword(it))
                },
                hint = stringResource(R.string.password_hint),
                keyboardType = KeyboardType.Password,
                error = when (passwordState.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.error_field_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_PASSWORD_LENGTH)
                    }
                    is AuthError.InvalidPassword -> {
                        stringResource(id = R.string.invalid_password)
                    }
                    else -> ""
                },
                isPasswordVisible = passwordState.isPasswordVisible,
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
                enabled = !registerState.isLoading,
                modifier = Modifier.align(Alignment.End)
            ){
                Text(
                    text = stringResource(R.string.register),
                    color = MaterialTheme.colors.onPrimary
                )
            }

            if(registerState.isLoading) {
                CircularProgressIndicator()
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