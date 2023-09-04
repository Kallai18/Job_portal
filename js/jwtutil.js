function getJWTPayload(jwt) {
    const [, payloadBase64] = jwt.split('.'); // Ignore header and signature
    const payload = JSON.parse(atob(payloadBase64));
    return payload;
  }

  