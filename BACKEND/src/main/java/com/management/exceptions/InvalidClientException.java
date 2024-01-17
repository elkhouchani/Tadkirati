package com.management.exceptions;

public class InvalidClientException extends RuntimeException{
        public InvalidClientException() {super("Email is mandatory");}
}
