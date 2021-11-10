package com.astute.socialnetworkdefense.feature_auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import com.astute.socialnetworkdefense.core.util.Screen
import com.astute.socialnetworkdefense.core.presentation.util.UiEvent
import com.astute.socialnetworkdefense.core.util.asString
import com.astute.socialnetworkdefense.feature_auth.presentation.util.AuthError
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (String) -> Unit = {},
    onLogin: () -> Unit = {},
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val state = viewModel.loginState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is UiEvent.ShowSnackbar  -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
                is UiEvent.Navigate -> {
                    onNavigate(event.route)
                }
                is UiEvent.OnLogin -> {
                    onLogin()
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
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.h1,
            )
            Spacer(modifier = Modifier.height(SpaceSmall))

            //Username Field
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredEmail(it))
                },
                hint = stringResource(R.string.login_hint),
                error = when (emailState.error) {
                    is AuthError.FieldEmpty -> stringResource(id = R.string.error_field_empty)
                    else -> ""
                },
                keyboardType = KeyboardType.Email,
                )
            Spacer(modifier = Modifier.height(SpaceMedium))

            //Password field
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnteredPassword(it))
                },
                hint = stringResource(R.string.password_hint),
                error = when (passwordState.error) {
                    is AuthError.FieldEmpty -> stringResource(id = R.string.error_field_empty)
                    else -> ""
                },
                isPasswordVisible = state.isPasswordVisible,
                keyboardType = KeyboardType.Password,
                onPasswordToggleClick = {
                    viewModel.onEvent(LoginEvent.TogglePasswordVisibility)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))

            //Login Button
            Button(
                onClick = {
                    viewModel.onEvent(LoginEvent.Login)
                },
                modifier = Modifier.align(Alignment.End)
            ){
                Text(
                    text = stringResource(R.string.login),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
            }

        }

        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account_yet))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_up)
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
                    onNavigate(Screen.RegisterScreen.route)
                }

            )
    }
}