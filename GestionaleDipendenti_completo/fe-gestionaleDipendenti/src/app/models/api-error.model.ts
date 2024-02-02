import { ErrorDetail } from "./api-error-detail.model";

export interface ApiError {
    error: string;
    timestamp: Date;
    path: string;
    details: ErrorDetail;
}