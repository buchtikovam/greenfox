import { useEffect } from "react";
import CartComponent from "../../components/CartComponent/CartComponent";
import { useRent } from "../../hooks/useRent";

export default function Cart() {
  const { fetchByStatus } = useRent();

  useEffect(() => {
    fetchByStatus("PENDING");
  }, [fetchByStatus]);

  return <CartComponent />;
}
